import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Login from './components/Login'
import Signup from './components/Signup'
import SignupAdmin from './components/SignupAdmin'
import UserDashboard from './pages/UserDashboard'
import AdminDashboard from './pages/AdminDashboard'
import BiodataForm from './components/BiodataForm'

function App() {
  return (
    <Router>
      <div className="min-h-screen flex justify-center items-center bg-gray-100">
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path='/signup-admin' element={<SignupAdmin />}/>
          <Route path='/userdashboard' element={<UserDashboard />}/>
          <Route path='/admindashboard' element={<AdminDashboard />} />
          <Route path='/biodataform' element={<BiodataForm />}/>
        </Routes>
      </div>
    </Router>
  )
}

export default App
