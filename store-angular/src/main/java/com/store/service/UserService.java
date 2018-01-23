package com.store.service;

import com.store.domain.User;
import com.store.domain.UserBilling;
import com.store.domain.UserPayment;
import com.store.domain.UserShipping;
import com.store.domain.security.UserRole;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Set;

/**
 * Interface of the service layer describes a set of methods for working
 * with objects of the class {@link User}.
 *
 * @author Buchynska S
 * @see User
 * @see com.store.service.impl.UserServiceImpl
 */
@Service
public interface UserService {

    User findByUsername(String username);

    User findByEmail (String email);

    User save(User user);

    User findById(Long id);

    User createUser(User user, Set<UserRole> userRoles);

    void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user);

    void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

    void setUserDefaultPayment(Long userPaymentId, User user);

    void updateUserShipping(UserShipping userShipping, User user);

    void setUserDefaultShipping(Long userShippingId, User user);

}
