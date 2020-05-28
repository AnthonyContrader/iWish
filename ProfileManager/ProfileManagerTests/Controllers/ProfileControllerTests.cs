﻿using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Routing;
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
            ProfileDTO profile = profiles.FirstOrDefault(obj => obj.id == id);
            service.Setup(x => x.read(id)).Returns(profile);

            var controller = new ProfileController(service.Object);

            var result = (controller.Get(id) as OkObjectResult).Value as ProfileDTO;


            Assert.AreEqual(2, result.id);


        }

        [Test()]
        public void PostTest()
        {
            ProfileDTO dto = new ProfileDTO{id=3 ,name = "Ugo" };
            var service = new Mock<AService<ProfileDTO>>();
            List<ProfileDTO> profiles = GetFakeData();
            service.Setup(x => x.insert(dto)).Callback(() => { profiles.Add(dto); });

            new ProfileController(service.Object).Post(dto);
            Assert.AreEqual(3, profiles.Count());
        }

        [Test()]
        public void PutTest()
        {
            ProfileDTO dto = new ProfileDTO { id = 2, name = "SuperMario" };
            var service = new Mock<AService<ProfileDTO>>();
            List<ProfileDTO> profiles = GetFakeData();
            service.Setup(x => x.update(dto)).Callback(() =>
            {

                var obj = profiles.FirstOrDefault(x => x.id == dto.id);
                if (obj != null) {
                    obj.name = dto.name;
                    obj.image = dto.image;
                    obj.surname = dto.surname;
                }
            });

            new ProfileController(service.Object).Put(dto);
            Assert.AreEqual(dto.name, profiles.ElementAt((int)dto.id-1).name);



        }

        [Test()]
        public void DeleteTest()
        {
            long id = 2;
            var service = new Mock<AService<ProfileDTO>>();
            List<ProfileDTO> profiles = GetFakeData();
            service.Setup(x => x.delete(id)).Callback(() => { profiles.RemoveAll(element => element.id == id); });

            new ProfileController(service.Object).Delete(id);
            Assert.AreEqual(1, profiles.Count());

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