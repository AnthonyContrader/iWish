using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProfileManager.Converter
{
    interface IConverter<Entity,DTO>
    {
        public Entity toEntity(DTO dto);
        public DTO toDTO(Entity entity);
        public List<DTO> toDTOList(List<Entity> entityList);
    }
}
