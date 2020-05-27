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
            var service = new Mock<AService<ProfileDTO>>();
            List<ProfileDTO> profiles = GetFakeData();
            service.Setup(x => x.getAll()).Returns(profiles);
      
            var controller = new ProfileController(service.Object);

            var results = controller.GetAll() as OkObjectResult;
            var list = results.Value as List<ProfileDTO>;
            var count = list.Count();
            Assert.AreEqual(count, 2);
        }

        [Test()]
        public void GetTest()
        {
            long id = 2;
            var service = new Mock<AService<ProfileDTO>>();
            List<ProfileDTO> profiles = GetFakeData();
            ProfileDTO profile = profiles.ElementAt((int)(id-1));
            service.Setup(x => x.read(id)).Returns(profile);

            var controller = new ProfileController(service.Object);

            var result = (controller.Get(id) as OkObjectResult).Value as ProfileDTO;


            Assert.AreEqual(2, result.id);


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
            profiles.Add(new ProfileDTO {id = 1, name = "Luigi"});
            profiles.Add(new ProfileDTO {id = 2, name = "Mario" });
            return profiles;
        }
    }
}