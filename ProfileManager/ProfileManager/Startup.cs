using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Consul;
using microserviceA.Consul;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;
using ProfileManager.DBContexts;
using ProfileManager.Repository;

namespace ProfileManager
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddDbContext<DatabaseContext>(c => c.UseSqlServer(Configuration.GetConnectionString("ProfileDB")));
            services.AddTransient<ProfileRepository>();

            // Add Cors
            services.AddCors(o => o.AddPolicy("MyPolicy", builder =>
            {
                builder.AllowAnyOrigin()
                       .AllowAnyMethod()
                       .AllowAnyHeader();
            }));
            services.AddControllers();

            services.AddSingleton<IHttpContextAccessor, HttpContextAccessor>();

            services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme);

            services.AddAuthorization();

            services.AddConsul(Configuration);

            services.AddSwaggerDocument(c =>
            {
                c.Title = "ProfileManager API";
                c.Description = "ProfileManager API documentation";
            });
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, Microsoft.AspNetCore.Hosting.IHostingEnvironment env, Microsoft.AspNetCore.Hosting.IApplicationLifetime lifetime, IConsulClient consulClient, IOptions<ServiceRegisterOptions> serviceRegisterOptions)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseHttpsRedirection();

            app.UseCors("MyPolicy");

            string[] consumes = new string[1] { "application/json" };

            app.UseOpenApi(c => {

                c.Path = "/v2/api-docs";
                c.PostProcess = (document, request) =>
                {
                    document.Host = Configuration["Swagger:Host"];
                    document.BasePath = "/" + Configuration["ServiceRegister:ServiceName"];
                    document.Consumes = consumes;

                };
            });
            app.UseSwaggerUi3(c =>
            {
                c.DocumentPath = "/v2/api-docs";
                c.Path = "/swagger";

            });


            app.UseConsul(lifetime, consulClient, serviceRegisterOptions);
            app.UseRouting();




            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllers();
            });
        }
    }
}
