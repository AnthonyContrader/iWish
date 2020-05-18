using ProfileManager.DTO;
using ProfileManager.Models;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.Converter
{
    public class ProfileConverter:IConverter<Profile, ProfileDTO>
    {
        public ProfileDTO toDTO(Profile profile) {
            ProfileDTO profileDTO = new ProfileDTO(profile.id, profile.name, profile.surname, profile.birthday, profile.email, profile.image, profile.proprietario_id);
            return profileDTO;
        }

        public Profile toEntity (ProfileDTO profileDTO)
        {
            Profile profile = new Profile(profileDTO.id, profileDTO.name, profileDTO.surname, profileDTO.birthday, profileDTO.email, profileDTO.image, profileDTO.proprietario_id);
            return profile;
        }
        public List<ProfileDTO> toDTOList (List<Profile> profileList ) {
            List<ProfileDTO> profileDTOList = new List<ProfileDTO>();
            foreach (Profile p in profileList) {
                profileDTOList.Add(toDTO(p));
            }
            return profileDTOList;
        }
    }
}
