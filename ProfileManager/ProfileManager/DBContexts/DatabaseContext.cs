using Microsoft.EntityFrameworkCore;
using ProfileManager.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.DBContexts
{
    public class DatabaseContext: DbContext
    {
        public DatabaseContext (DbContextOptions<DatabaseContext> options) : base(options) { }
        public DbSet<Profile> Profiles { get; set; }

    }
}
