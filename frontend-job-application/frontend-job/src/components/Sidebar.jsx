import React from 'react'
import { Link } from 'react-router-dom'

const Sidebar = () => {
  return (
      <div className="w-1/4 h-screen bg-gray-800 text-white p-4">
          <h2 className="text-2xl mb-6">Dashboard</h2>
          <nav>
              <ul>
                  <li className="mb-4">
                      <Link to="/biodataform" className="text-white hover:text-gray-300">Biodata</Link>
                  </li>
              </ul>
          </nav>
      </div>
  )
}

export default Sidebar
