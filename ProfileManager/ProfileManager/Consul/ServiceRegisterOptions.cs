

namespace microserviceA.Consul
{
    public class RegisterOptions
    {
        public string HttpEndpoint { get; set; }
    }

    public class ServiceRegisterOptions
    {
        public bool IsActive { get; set; }

        public string ServiceName { get; set; }

        public string ServiceHost { get; set; }

        public int ServicePort { get; set; }

        public RegisterOptions Register { get; set; }
    }
}
