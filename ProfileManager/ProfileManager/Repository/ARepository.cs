using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.Repository
{
    public abstract class ARepository<T> : IRepository<T>
    {
         public abstract IEnumerable<T> GetAll();

        public abstract T GetById(long entityId);

        public abstract void Insert(T entity);

        public abstract void Delete(long entityId);

         public abstract void Update(T entity);
    }
}
