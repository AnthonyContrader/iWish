
using ProfileManager.DBContexts;
using ProfileManager.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.Repository
{

    public class ProfileRepository : IRepository<Profile>
    {
        private readonly DatabaseContext _dbContext;

        public ProfileRepository(DatabaseContext dbContext)
        {
            this._dbContext = dbContext;
        }

        public void Delete(long profileId)
        {
            var profile = _dbContext.Profiles.Find(profileId);
            _dbContext.Profiles.Remove(profile);
            _dbContext.SaveChanges();
        }

        public Profile GetById(long profileId)
        {
            return _dbContext.Profiles.Find(profileId);
        }

        public IEnumerable<Profile> GetAll()
        {
            return _dbContext.Profiles.ToList();
        }

        public void Insert(Profile profile)
        {
            _dbContext.Add(profile);
            _dbContext.SaveChanges();
        }

        public void Update(Profile profile)
        {
            _dbContext.Entry(profile).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            _dbContext.SaveChanges();
        }
    }
}