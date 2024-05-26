import React, { useEffect, useState } from 'react'
import axios from 'axios'

const AdminDashboard = () => {
    const [biodataList, setBiodataList] = useState([])

    useEffect(() =>{
        const fetchBiodata = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/biodata')
                setBiodataList(response.data)
            } catch (error){
                console.error('Error fetching biodata: ', error)
            }
        }
        fetchBiodata();
    }, [])
  return (
      <div className="max-w-4xl mx-auto mt-10">
          <h2 className="text-3xl font-bold mb-6">Admin Dashboard</h2>
          <table className="min-w-full bg-white">
              <thead>
                  <tr>
                      <th className="py-2">Nama</th>
                      <th className="py-2">Tempat, Tanggal Lahir</th>
                      <th className="py-2">Posisi yang dilamar</th>
                      <th className="py-2">Actions</th>
                  </tr>
              </thead>
              <tbody>
                  {biodataList.map((biodata) => (
                      <tr key={biodata.id}>
                          <td className="py-2">{biodata.nama}</td>
                          <td className="py-2">{`${biodata.tempatLahir}, ${biodata.tanggalLahir}`}</td>
                          <td className="py-2">{biodata.posisi}</td>
                          <td className="py-2">
                              <button className="text-blue-500 hover:underline">View</button>
                              <button className="text-green-500 hover:underline ml-4">Edit</button>
                              <button className="text-red-500 hover:underline ml-4">Delete</button>
                          </td>
                      </tr>
                  ))}
              </tbody>
          </table>
      </div>
  )
}

export default AdminDashboard
