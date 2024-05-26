import React, { useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode'

const Login = () => {
    const[email, setEmail] = useState('');
    const[password, setPassword] = useState('');
    const navigate = useNavigate()

    const handleLogin = async () => {
        try{
            const response = await axios.post('http://localhost:8080/api/v1/auth/login',{
                email,
                password
            });
            if(response.status === 200){
                const token = response.data.token
                localStorage.setItem('jwtToken', token) //save jwt token to local storage
                const decodedToken = jwtDecode(token)
                const role = decodedToken.role
                localStorage.setItem('role', role) //save user role to localStorage
                console.log(role); //loggin
                console.log(token); //loggin
                if (role === 'admin') {
                    navigate('/admin-dashboard')
                } else {
                    navigate("/user-dashboard");
                }
            } else {
                console.error('Failed to login')
            }

        } catch (error){
            console.error('Error loggin in: ', error);
        }
    };
  return (
      <div className="max-w-md mx-auto mt-10 border-solid border-2 border-black p-20">
          <h2 className="text-3xl font-bold mb-6">Login</h2>
          <form onSubmit={handleLogin}>
              <div className="mb-4">
                  <label className="block text-gray-700">Email</label>
                  <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} className="w-full px-3 py-2 border rounded" />
              </div>
              <div className="mb-4">
                  <label className="block text-gray-700">Password</label>
                  <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} className="w-full px-3 py-2 border rounded" />
              </div>
              <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">Login</button>
              <button className="bg-blue-500 text-white px-4 mx-4 py-2 rounded hover:bg-blue-600"><Link to="/signup">Sign up</Link></button>
          </form>
      </div>
  )
}

export default Login
