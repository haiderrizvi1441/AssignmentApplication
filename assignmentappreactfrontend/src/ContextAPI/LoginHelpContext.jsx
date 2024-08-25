import React,{createContext, useContext, useState, useEffect} from 'react'
import axios from 'axios';


// Creating the context to export 
export const LoginContext = createContext(null);

// Function to return required info
export const useLogin = () => {
    const logins = useContext(LoginContext);

    return logins;
}

// Creating context provider
export const LoginContextProvider = (props) => {
    // In context , we only require the ID , so to fetch the required info with it later to load the rest of the user data on his homepage
    const [loginData, setLoginData] = useState(0);


    return (
        <LoginContext.Provider value={{loginData, setLoginData}}>
            {props.children}
        </LoginContext.Provider>
    )
}

function LoginHelpContext() {
  return (
    <div>LoginHelpContext</div>
  )
}

export default LoginHelpContext