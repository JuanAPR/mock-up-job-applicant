import React, { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const SignupAdmin = () => {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const navigate = useNavigate()

    const handleSignup = async () => {
        try {
            const response = await axios.post('http://localhost:8080/api/v1/auth/register-admin', {
                email,
                password
            })
            console.log('Sign-up Admin success: ', response.data)
            navigate("/")
        } catch (error) {
            console.error('Error signing up: ', error)
        }
    }
    return (
        <div className="max-w-md mx-auto border-solid rounded-lg border-2 border-black p-2">
            <h2 className="text-2xl font-bold mb-4">Sign Up</h2>
            <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} className="w-full px-3 py-2 mb-4 border rounded" />
            <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} className="w-full px-3 py-2 mb-4 border rounded" />
            <button onClick={handleSignup} className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">Sign Up</button>
        </div>
    )
}

export default SignupAdmin
