using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.DTO
{
    public class ProfileDTO
    {
        public ProfileDTO(long id, string name, string surname, DateTime birthday, string email, string image, long proprietario_id)
        {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.email = email;
            this.image = image;
            this.proprietario_id = proprietario_id;
        }
        public ProfileDTO() { }

        public long id { get; set; }
        public string name { get; set; }
        public string surname { get; set; }
        
        public DateTime birthday { get; set; }
        
        public string email { get; set; }
        
        public string image { get; set; }
        public long proprietario_id { get; set; }
    }
}
