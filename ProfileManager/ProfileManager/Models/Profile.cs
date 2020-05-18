using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.Contracts;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.Models
{
    public class Profile
    {
        public Profile(long id, string name, string surname, DateTime birthday, string email, string image, long proprietario_id)
        {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.email = email;
            this.image = image;
            this.proprietario_id = proprietario_id;
        }
        public Profile() { }

        [Key]
        public long id { get; set; }
        public string name { get; set; }
        public string surname { get; set; }
        [DataType(DataType.DateTime)]
        public DateTime birthday { get; set; }
        [DataType(DataType.EmailAddress)]
        public string email { get; set; }
        [StringLength(10000000)]
        public string image { get; set; }
        public long proprietario_id { get; set; }

    }
}
