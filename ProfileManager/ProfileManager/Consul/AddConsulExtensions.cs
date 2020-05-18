using Consul;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Options;
using System;


namespace microserviceA.Consul
{
    public static class AddConsulExtensions
    {
   
            public static IServiceCollection AddConsul(this IServiceCollection services, IConfiguration configuration)
            {
                services.Configure<ServiceRegisterOptions>(configuration.GetSection("ServiceRegister"));
                services.AddSingleton<IConsulClient>(c => new ConsulClient(cfg =>
                {
                    var serviceConfiguration = c.GetRequiredService<IOptions<ServiceRegisterOptions>>().Value;
                    if (!string.IsNullOrWhiteSpace(serviceConfiguration.Register.HttpEndpoint))
                    {
                        cfg.Address = new Uri(serviceConfiguration.Register.HttpEndpoint);
                    }
                }));
                return services;
            }
        }
    }

