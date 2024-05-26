import React from 'react'
import { Link } from 'react-router-dom'
import Sidebar from '../components/Sidebar'

const UserDashboard = ({children}) => {
  return (
    <div className="max-w-4xl mx-auto mt-10 border-solid border-2 px-10 border-black">
      <h2 className="text-3xl font-bold mb-6">User Dashboard</h2>
      <Link to="/biodataform" className="text-blue-500 hover:underline">Enter Biodata</Link>
    </div>
  )
}

export default UserDashboard
