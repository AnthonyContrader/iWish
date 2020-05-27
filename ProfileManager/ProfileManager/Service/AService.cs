using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.Service
{
    public abstract class AService<DTO> : IService<DTO>
    {
        public abstract List<DTO> getAll();

        public abstract void insert(DTO dto);

        public abstract DTO  read(long id);

        public abstract void update(DTO dto);

        public abstract void delete(long id);


    }
}
