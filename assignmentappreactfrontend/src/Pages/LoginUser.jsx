import React,{useState, useContext} from 'react'
import axios from 'axios'
import {Link, useNavigate} from 'react-router-dom'
import { LoginContext,useLogin } from '../ContextAPI/LoginHelpContext';

function LoginUser() {

  const apiURL = "http://localhost:8080/api/v1/user/login";

  const navigate = useNavigate();
  const[email, setEmail] = useState('');
  const[password, setPassword] = useState('');
  const[role, setRole] = useState('');

  // CONTEXT CONFIG
  const logins = useLogin();

  const submitHandler = async (e) => {
    e.preventDefault();

    // Guiding USERS to correct Home page as per the Role

    try{
      await axios.post(apiURL,{
        email:email,
        password:password,
        role:role
      }).then((result)=>{
        console.log(result.data);

        // User does not exist
        if(result.data.message === "User does not exist"){
          console.alert("User does not exist")
        }
        // User exist , password wrong
        else if(result.data.message === "Password does not match"){
          console.alert("Password does not match, please try again")
        }
        // User exist , password correct , role wrong
        else if(result.data.message === "Login Failed"){
          console.alert("Login Failed for selected Role!!")
        }
        // User exist, password correct, role correct
        else if(result.data.message === "Login Success"){
          // LOGIN SUCCESS - Context to be stored
          logins.setLoginData(result.data.id);
          console.log("The Context is now updated for the user : {}", result.data.id);
          // Switch to HOMEPAGE as per the role
          switch(role){
            case "ADMIN":
              navigate("/adminhomepage")
              break;
            case "STUDENT":
              navigate("/studenthomepage")
              break;
            case "REVIEWER":
              navigate("/reviewerhomepage")
              break;
            default:
              navigate("/wrongrolefallback")
              break;
          }
        }

      },
      fail => {console.error(fail)}
    )

    }
    catch(err){
      alert(err.response.data);
    }



  }


  return (
    <div className="bg-slate-900 text-white min-h-screen flex items-center justify-center">
      <div className="bg-white p-8 rounded-lg shadow-lg w-96">
        <h2 className="text-2xl mb-4 text-black font-bold">Login</h2>
        <div className="mb-4 flex items-center justify-between bg-gray-300 border-slate-700 border-2 "></div>
        <form onSubmit={submitHandler}>

          <div className="mb-4 text-black font-semibold">
            <input
              type="email"
              name="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="Email"
              className="w-full p-2 border rounded focus:outline-none focus:border-lime-400 "
              required
            />
          </div>
          <div className="mb-4 text-black font-semibold">
            <input
              type="password"
              name="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              placeholder="Password"
              className="w-full p-2 border rounded focus:outline-none focus:border-lime-400"
              required
            />
          </div>


          <div className='radiobuttons text-bold text-black font-semibold bg-gray-400'>
            <p className='underline'>Login as </p>
            <input className="m-2" type="radio" value="ADMIN" checked={role === "ADMIN"} onChange={() => { setRole('ADMIN') }} />
            <label className="m-2">Admin</label>
            <input className="m-2" type="radio" value="REVIEWER" checked={role === "REVIEWER"} onChange={() => { setRole('REVIEWER') }} />
            <label className="m-2">Reviewer</label>
            <input className="m-2" type="radio" value="STUDENT" checked={role === "STUDENT"} onChange={() => { setRole('STUDENT') }} />
            <label className="m-2">Student</label>
          </div>


          <button
            type="submit"
            className="w-full p-2 bg-lime-400 text-white font-semibold rounded hover:bg-opacity-90 focus:outline-none">
            Login
          </button>
        </form>
        <div className="text-center mt-4">
          <p className='text-black font-semibold'>
            New to AssignHelp ? {' '}
            <a href="#" className="text-lime-400 hover:underline hover:text-lime-800">
              <Link to="/register">Register</Link>
            </a>
          </p>
        </div>
      </div>
    </div>
  )
}

export default LoginUser