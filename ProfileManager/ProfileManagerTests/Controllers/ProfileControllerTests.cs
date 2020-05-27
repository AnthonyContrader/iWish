using Microsoft.AspNetCore.Mvc;
using Moq;
using NUnit.Framework;
using ProfileManager.DTO;
using ProfileManager.Service;

using System.Collections.Generic;
using System.Linq;


namespace ProfileManager.Controllers.Tests
{
    [TestFixture()]
    public class ProfileControllerTests
    {
        [Test()]
        public void ProfileControllerTest()
        {
            Assert.Fail();
        }

        [Test()]
        public void GetAllTest()
        {
            var repository = new Mock<AService<ProfileDTO>>();
            List<ProfileDTO> profiles = GetFakeData();
            repository.Setup(x => x.getAll()).Returns(profiles);
      
            var controller = new ProfileController(repository.Object);

            var results = controller.GetAll() as OkObjectResult;
            var list = results.Value as List<ProfileDTO>;
            var count = list.Count();
            Assert.AreEqual(count, 2);
        }

        [Test()]
        public void GetTest()
        {
            Assert.Fail();
        }

        [Test()]
        public void PostTest()
        {
            Assert.Fail();
        }

        [Test()]
        public void PutTest()
        {
            Assert.Fail();
        }

        [Test()]
        public void DeleteTest()
        {
            Assert.Fail();
        }

        private List<ProfileDTO> GetFakeData()
        {
            var profiles = new List<ProfileDTO>();
            profiles.Add(new ProfileDTO { name = "Luigi"});
            profiles.Add(new ProfileDTO { name = "Mario" });
            return profiles;
        }
    }
}