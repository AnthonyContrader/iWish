using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Transactions;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ProfileManager.DTO;
using ProfileManager.Models;
using ProfileManager.Repository;
using ProfileManager.Service;

namespace ProfileManager.Controllers
{
    [Authorize(AuthenticationSchemes =JwtBearerDefaults.AuthenticationScheme)]
    [Route("api/[controller]")]
    [ApiController]
    [Consumes("application/json")]
    public class ProfileController : ControllerBase
    {
        private readonly AService<ProfileDTO> _profileService;

        public ProfileController(AService<ProfileDTO> service)
        {

            _profileService = service;
        }
        // GET: api/Product
        [HttpGet]
        public IActionResult GetAll()
        {
            var profiles = _profileService.getAll();
            return new OkObjectResult(profiles);
        }

        // GET: api/Product/5
        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var profile = _profileService.read(id);
            return new OkObjectResult(profile);
        }

        // POST: api/Product
        [HttpPost]

        public IActionResult Post([FromBody] ProfileDTO profileDTO)
        {
            using (var scope = new TransactionScope())
            {
                _profileService.insert(profileDTO);
                scope.Complete();
                return CreatedAtAction(nameof(Get), new { id = profileDTO.id }, profileDTO);

            }

        }

        // PUT: api/Product/
        [HttpPut]
        public IActionResult Put([FromBody] ProfileDTO profileDTO)
        {
            if (profileDTO != null)
            {
                using (var scope = new TransactionScope())
                {
                    _profileService.update(profileDTO);
                    scope.Complete();
                    return new OkResult();
                }
            }
            return new NoContentResult();
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            _profileService.delete(id);
            return new OkResult();
        }
    }
}
