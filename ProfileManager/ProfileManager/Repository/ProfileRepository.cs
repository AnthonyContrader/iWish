
using ProfileManager.DBContexts;
using ProfileManager.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.Repository
{

    public class ProfileRepository : ARepository<Profile>
    {
        private readonly DatabaseContext _dbContext;

        public ProfileRepository(DatabaseContext dbContext)
        {
            this._dbContext = dbContext;
        }

        override
        public void Delete(long profileId)
        {
            var profile = _dbContext.Profiles.Find(profileId);
            _dbContext.Profiles.Remove(profile);
            _dbContext.SaveChanges();
        }

        override
        public Profile GetById(long profileId)
        {
            return _dbContext.Profiles.Find(profileId);
        }

        override
        public IEnumerable<Profile> GetAll()
        {
            return _dbContext.Profiles.ToList();
        }

        override
        public void Insert(Profile profile)
        {
            _dbContext.Add(profile);
            _dbContext.SaveChanges();
        }

        override
        public void Update(Profile profile)
        {
            _dbContext.Entry(profile).State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            _dbContext.SaveChanges();
        }
    }
}