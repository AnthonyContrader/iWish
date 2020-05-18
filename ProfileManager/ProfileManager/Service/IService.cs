using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.Service
{
    interface IService<DTO>
    {
        public List<DTO> getAll();
        public void insert(DTO dto);
        public void update(DTO dto);
        public void delete(long id);
        public DTO read(long id);


    }
}
