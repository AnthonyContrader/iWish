using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.Repository
{
    interface IRepository<T>
    {
        IEnumerable<T> GetAll();

        T GetById(long entityId);

        void Insert(T entity);

        void Delete(long entityId);

        void Update(T entity);
    }
}