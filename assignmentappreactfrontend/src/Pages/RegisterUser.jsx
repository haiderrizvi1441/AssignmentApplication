import React,{useState} from 'react'
import {Link, useNavigate} from 'react-router-dom';
import axios from 'axios';


function RegisterUser() {

    let apiURL = "http://localhost:8080/api/v1/user/createuser";
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    // Will use radio button switch
    const [role, setRole] = useState('');

    const register = async(e) => {
        e.preventDefault();
        
        try{
            await axios.post(apiURL,{
                username: username,
                email: email,
                password: password,
                role: role
            });
            alert("You have successfully registered")
            navigate("/login");
        }
        catch(err){
            alert(err.response.data);
        }
    }




  return (
    <div className="bg-slate-900 text-white min-h-screen flex items-center justify-center">
      <div className="bg-white p-8 rounded-lg shadow-lg w-96">
        <h2 className="text-2xl mb-4 text-black font-bold">Register</h2>
        <div className="mb-4 flex items-center justify-between bg-gray-300 border-slate-700 border-2"></div>
        <form onSubmit={register} className='text-black font-semibold'>
          <div className="mb-4 ">
            <input
              type="text"
              name="firstName"
              value={username}
              onChange={(e) => {
                setUsername(e.target.value);
              }}
              placeholder="Username"
              className="w-full p-2 border rounded focus:outline-none focus:border-lime-400"
              required
            />
          </div>
          {/* <div className="mb-4">
            <input
              type="text"
              name="lastName"
              value={lastname}
              onChange={(e) => {
                setLastName(e.target.value);
              }}
              placeholder="Last Name"
              className="w-full p-2 border rounded focus:outline-none focus:border-lime-400"
              required
            />
          </div> */}
          <div className="mb-4">
            <input
              type="email"
              name="email"
              value={email}
              onChange={(e) => {
                setEmail(e.target.value);
              }}
              placeholder="Email"
              className="w-full p-2 border rounded focus:outline-none focus:border-lime-400"
              required
            />
          </div>
          <div className="mb-4">
            <input
              type="password"
              name="password"
              value={password}
              onChange={(e) => {
                setPassword(e.target.value);
              }}
              placeholder="Password"
              className="w-full p-2 border rounded focus:outline-none focus:border-lime-400"
              required
            />
          </div>
          <div className='radiobuttons text-bold text-black font-semibold bg-gray-400'>
            <p className='underline'>Register as </p>
            <input className="m-2" type="radio" value="admin" checked={role === "ADMIN"} onChange={()=> {setRole('ADMIN')}}/>
            <label className="m-2">Admin</label>
            <input className="m-2" type="radio" value="vendor" checked={role === "REVIEWER"} onChange={()=> {setRole('REVIEWER')}} />
            <label className="m-2">Reviewer</label>
            <input className="m-2" type="radio" value="user" checked={role === "STUDENT"} onChange={()=> {setRole('STUDENT')}}/>
            <label className="m-2">Student</label>
          </div>
          
          <button
            type="submit"
            className="w-full p-2 bg-lime-400 text-white font-semibold rounded hover:bg-opacity-90 focus:outline-none">
            Register
          </button>
        </form>
        <div className="text-center mt-4">
          <p className='text-black font-semibold'>
            Already have an account?<Link to="/login">Login</Link>
          </p>
        </div>
      </div>
    </div>
  )
}

export default RegisterUser