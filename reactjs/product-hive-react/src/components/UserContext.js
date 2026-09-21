import React, { useEffect } from "react";
import { createContext, useContext, useState } from 'react';
import AuthenticationService from '../service/AuthenticationService';
const UserContext = createContext();

export const useUserContext = () => {
  return useContext(UserContext);
};

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState('');
  const isUserLoggedIn = AuthenticationService.isUserLoggedIn();

  // Fetch the user name when the component mounts
  useEffect(() => {
    const userId = AuthenticationService.getLoggedInUserName();
    setUser(userId);
  }, []);

  const handleLogout = () => {
    AuthenticationService.logout();
    setUser(''); // Clear the user name upon logout
  };

  return (
    <UserContext.Provider value={{ user, isUserLoggedIn, handleLogout }}>
      {children}
    </UserContext.Provider>
  );
};
