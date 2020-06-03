using Microsoft.AspNetCore.Mvc;
using Moq;
using NUnit.Framework;
using ProfileManager.DTO;
using ProfileManager.Models;
using ProfileManager.Repository;
using ProfileManager.Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProfileManager.Service.Tests
{
    [TestFixture()]
    public class ProfileServiceTests
    {
        
        [Test()]
        public void getAllTest()
        {
            var repository = new Mock<ARepository<Profile>>();
            List<Profile> profiles = GetFakeData();
            repository.Setup(x => x.GetAll()).Returns(profiles);

            var service = new ProfileService(repository.Object);

            var results = service.getAll();
            var count = results.Count();
            Assert.AreEqual(count, 2);
        }

        [Test()]
        public void insertTest()
        {
            ProfileDTO dto = new ProfileDTO { id = 3, name = "Francesco" };
            var _repository = new Mock<ARepository<Profile>>();
            List<Profile> profiles = GetFakeData();
            _repository.Setup(x => x.Insert(It.IsAny<Profile>())).Callback<Profile>((z) => profiles.Add(z));
            
            
            new ProfileService(_repository.Object).insert(dto);
            Assert.AreEqual(dto.name, profiles.FirstOrDefault(p => p.id == dto.id).name);
        }

        [Test()]
        public void updateTest()
        {

            ProfileDTO dto = new ProfileDTO { id = 2, name = "Maham" };
            var _repository = new Mock<ARepository<Profile>>();
            List<Profile> profiles = GetFakeData();
            _repository.Setup(x => x.Update(It.IsAny<Profile>())).Callback<Profile>((profile) =>
            {
                var obj = profiles.FirstOrDefault(x => x.id == profile.id);
                if (obj != null)
                {
                    obj.name = profile.name;
                    obj.image = profile.image;
                    obj.surname = profile.surname;
                }
            });

            new ProfileService(_repository.Object).update(dto);
            Assert.AreEqual(dto.name, profiles.FirstOrDefault((p) => p.id == dto.id).name);

        }

        [Test()]
        public void deleteTest()
        {
            long id = 2;
            var repository = new Mock<ARepository<Profile>>();
            List<Profile> profiles = GetFakeData();
            repository.Setup(x => x.Delete(It.IsAny<long>())).Callback<long>((ID) => { profiles.RemoveAll(element => element.id == ID); });

            new ProfileService(repository.Object).delete(id);
            Assert.AreEqual(1, profiles.Count());
        }

        [Test()]
        public void readTest()
        {
            long id = 2;
            var repository = new Mock<ARepository<Profile>>();
            List<Profile> profiles = GetFakeData();
            
            repository.Setup(x => x.GetById(It.IsAny<long>())).Returns<long>((ID) => profiles.FirstOrDefault(profile => profile.id == ID));

            var service = new ProfileService(repository.Object);

            var result = service.read(id);

            Assert.AreEqual(2, result.id);
        }
        private List<Profile> GetFakeData()
        {
            var profiles = new List<Profile>();
            profiles.Add(new Profile { id = 1, name = "Luigi" });
            profiles.Add(new Profile { id = 2, name = "Mario" });
            return profiles;
        }
    }
}