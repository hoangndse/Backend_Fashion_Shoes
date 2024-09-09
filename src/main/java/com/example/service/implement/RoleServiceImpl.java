package com.example.service.implement;

import com.example.Entity.Role;
import com.example.constant.RoleConstant;
import com.example.mapper.RoleMapper;
import com.example.repository.RoleRepository;
import com.example.request.RoleRequest;
import com.example.response.ListRolesResponse;
import com.example.response.Response;
import com.example.exception.CustomException;
import com.example.service.RoleService;
import com.example.util.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MethodUtils methodUtils;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getById(Long id) throws CustomException {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        "Role not found with id: " + id,
                        HttpStatus.NOT_FOUND.value()
                ));
        return role;
    }

    @Override
    @Transactional
    public Role createRole(RoleRequest roleRequest) throws CustomException {

        roleRequest.setName(roleRequest.getName().toUpperCase());

        Optional<Role> roleExist = roleRepository.findByName(roleRequest.getName());

        if (roleExist.isPresent()) {
            throw new CustomException(
                    "Role is already exist with name: " + roleRequest.getName(),
                    HttpStatus.CONFLICT.value()
            );
        }
        String emailAdmin = methodUtils.getEmailFromTokenOfAdmin();

        Role role = new Role();
        roleMapper.roleRequestToRole(roleRequest, role);
        role.setCreatedBy(emailAdmin);

        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public Response deleteRole(Long id) throws CustomException {
        Role role = this.getById(id);
        if (role.getName().equals(RoleConstant.ADMIN)) {
            throw new CustomException("The ADMIN role cannot be deleted !!!", HttpStatus.FORBIDDEN.value());
        }
        roleRepository.deleteById(id);
        Response response = new Response();
        response.setMessage("Delete success !!!");
        response.setStatus(HttpStatus.OK.value());
        return response;
    }

    @Override
    @Transactional
    public Response deleteSomeRoles(List<Long> ids) {
        // lấy ra những role có trong list ids
        List<Role> rolesDelete = roleRepository.findAllById(ids);

        // lấy ra những id của các role tìm thấy
        List<Long> idRolesDelete = rolesDelete.stream().map(Role::getId).collect(Collectors.toList());

        // lấy ra những id của role không tồn tại
        List<Long> idsMiss = ids.stream().filter(id -> !idRolesDelete.contains(id)).collect(Collectors.toList());

        roleRepository.deleteAll(rolesDelete);

        String message = idsMiss.isEmpty() ? "Delete list roles success !!!"
                : "Delete list roles success, but not found ids: " + idsMiss.toString();

        Response response = new Response();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(message);

        return response;
    }

    @Override
    @Transactional
    public Role updateRole(Long id, RoleRequest roleRequest) throws CustomException {
        Role oldRole = this.getById(id);

        roleRequest.setName(roleRequest.getName().toUpperCase());

        Optional<Role> checkExist = roleRepository.findByName(roleRequest.getName());

        if (!checkExist.isPresent() || checkExist.get().getName().equals(oldRole.getName())) {
            String emailAdmin = methodUtils.getEmailFromTokenOfAdmin();

            roleMapper.roleRequestToRole(roleRequest, oldRole);
            oldRole.setUpdateBy(emailAdmin);

            return roleRepository.save(oldRole);
        } else {
            throw new CustomException("The " + checkExist.get().getName() + " role is already exist !!!", HttpStatus.CONTINUE.value());
        }
    }

    @Override
    public ListRolesResponse getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        ListRolesResponse listRolesResponse = new ListRolesResponse();
        listRolesResponse.setRoles(roles);
        listRolesResponse.setTotal(roles.size());

        return listRolesResponse;
    }

    @Override
    public Role findByName(String name) throws CustomException {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new CustomException("There is no role with name: " + name, HttpStatus.NOT_FOUND.value()));
        return role;
    }
}
