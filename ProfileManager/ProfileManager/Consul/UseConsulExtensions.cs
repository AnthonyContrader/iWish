using System;

using Consul;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Options;


namespace microserviceA.Consul
{
    public static class UseConsulExtensions
    {
        public static IApplicationBuilder UseConsul(this IApplicationBuilder app,
            IApplicationLifetime lifetime,
            IConsulClient consul,
            IOptions<ServiceRegisterOptions> serviceRegisterOptions)
        {
            var serviceId =
                $"{serviceRegisterOptions.Value.ServiceName}_{serviceRegisterOptions.Value.ServiceHost}_{serviceRegisterOptions.Value.ServicePort}";


            var registration = new AgentServiceRegistration()
            {
               
                Address = serviceRegisterOptions.Value.ServiceHost,
                ID = serviceId,
                Name = serviceRegisterOptions.Value.ServiceName,
                Port = serviceRegisterOptions.Value.ServicePort
            };

            consul.Agent.ServiceRegister(registration).GetAwaiter().GetResult();

            lifetime.ApplicationStopping.Register(() =>
            {
                consul.Agent.ServiceDeregister(serviceId).GetAwaiter().GetResult();
            });

            return app;
        }
    }
}
