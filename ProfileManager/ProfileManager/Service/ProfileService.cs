using ProfileManager.Converter;
using ProfileManager.DTO;
using ProfileManager.Models;
using ProfileManager.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Threading.Tasks;

namespace ProfileManager.Service
{
    public class ProfileService: IService<ProfileDTO>
    {
        private readonly ProfileConverter profileConverter;
        private readonly ProfileRepository profileRepository;
        public ProfileService(ProfileRepository profileRepository) {
            this.profileRepository = profileRepository;
            this.profileConverter = new ProfileConverter();
        }
        public List<ProfileDTO> getAll() {

            return this.profileConverter.toDTOList((List<Profile>)profileRepository.GetAll());
           
                
        }
        public void insert(ProfileDTO dto) {
            profileRepository.Insert(this.profileConverter.toEntity(dto));
        }
        public void update(ProfileDTO dto) {
            profileRepository.Update(this.profileConverter.toEntity(dto));

        }
        public void delete(long id) {
            profileRepository.Delete(id);
        }
        public ProfileDTO read(long id) {
          return  this.profileConverter.toDTO(profileRepository.GetById(id));
        }

    }
}
