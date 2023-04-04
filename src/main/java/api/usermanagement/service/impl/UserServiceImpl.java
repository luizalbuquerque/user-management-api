package api.usermanagement.service.impl;

import api.usermanagement.dto.UserDto;
import api.usermanagement.dto.UserUpdateForm;
import api.usermanagement.entity.RoleEntity;
import api.usermanagement.entity.UserEntity;
import api.usermanagement.exception.BusinessException;
import api.usermanagement.repository.RoleRepository;
import api.usermanagement.repository.UserRepository;
import api.usermanagement.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static api.usermanagement.util.ConstantUtils.DUPLICATE_USER;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public void createUser(UserDto userDto) {

        try{
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(userDto.getEmail());
            userEntity.setPassword(userDto.getPassword());

            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setName(userDto.getRoleEntity().get(0).getName());
            roleEntity.setDescription(userDto.getRoleEntity().get(0).getDescription());
            roleRepository.save(roleEntity);

            List<RoleEntity> roles = Collections.singletonList(roleEntity);
            userEntity.setRoleList(roles);

            userRepository.save(userEntity);

        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }

    @Override
    public Optional<UserEntity> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(long id) {
        return null;
    }

    @Override
    public UserDto updateByUserId(UserUpdateForm form, Long id) {

        Optional<UserEntity> op = userRepository.findById(id);
        if (op.isPresent()) {
            UserEntity obj = op.get();
            if (form.getPassword() != null) {
                obj.setEmail(form.getEmail());
            }
            if (form.getEmail() != null) {
                obj.setPassword(form.getPassword());
            }
            userRepository.save(obj);
            return convertToDto(obj);
        }
        return null;
    }

    // Converter ENTITY to DTO
    private UserDto convertToDto(UserEntity userEntity) {
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setEmail(userEntity.getEmail());
        dto.setPassword(userEntity.getPassword());
        return dto;
    }

    public void deleteById(Long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(DUPLICATE_USER);
        }
    }

    @Override
    public UserDto updateUserRoleByEmail(UserDto userDto) {

        UserEntity userEntity  = userRepository.findByEmail(userDto.getEmail());

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(userDto.getRoleEntity().get(0).getName());
        roleEntity.setDescription(userDto.getRoleEntity().get(0).getDescription());
        roleRepository.save(roleEntity);

        List<RoleEntity> roleList = new ArrayList<>();
        roleList.add(roleEntity);
        userEntity.setRoleList(roleList);

        userRepository.save(userEntity);


        return null;
    }
}