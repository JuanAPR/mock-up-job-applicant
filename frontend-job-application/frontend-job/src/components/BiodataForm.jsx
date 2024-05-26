import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'
import initialBiodata from '../config/BiodataConfig'
import DynamicFormSection from './DynamicFormSection'

const BiodataForm = () => {
    const [biodata, setBiodata] = useState(initialBiodata)
    const navigate = useNavigate();

    const handleChange = (e) => {
        const {name, value} = e.target
        setBiodata({ ...biodata, [name]: value })
    }

    const handleSubmit = async (e) =>{
        e.preventDefault();
        try{
            const response = await axios.post('http://localhost:8080/api/biodataAdd', biodata, {
                headers: {
                    'Content-Type': 'application/json',
                    Authorization: `Bearer ${localStorage.getItem('jwtToken')}`
                }
            })

            if (response.status === 201){
                console.log(response.data)
                navigate('/userdashboard')
            } else {
                console.error('Failed to submit biodata')
            }
        } catch (error) {
            console.error('An error occured: ', error)
        }
    }

    const renderInputField = (label, name, type='text') => (
        <div className="mb-4" key={name}>
            <label className="block text-gray-700">{label}</label>
            <input type={type} name={name} value={biodata[name]} onChange={handleChange} className="w-full px-3 py-2 border rounded" />
        </div>
    )
  return (
      <div className="max-w-4xl mx-auto mt-10 border-solid border-4 border-blue-300 p-8">
          <h2 className="text-3xl font-bold mb-6">Biodata Form</h2>
          <form onSubmit={handleSubmit}>
              {renderInputField('Posisi Yang Dilamar', 'posisi')}
              {renderInputField('Nama', 'nama')}
              {renderInputField('No KTP', 'noKtp')}
              {renderInputField('Tempat Lahir', 'tempatLahir')}
              {renderInputField('Tanggal Lahir', 'tanggalLahir', 'date')}
              {renderInputField('Jenis Kelamin', 'jenisKelamin')}
              {renderInputField('Agama', 'agama')}
              {renderInputField('Golongan Darah', 'golDarah')}
              {renderInputField('Status Perkawinan', 'statusPerkawinan')}
              {renderInputField('Alamat KTP', 'alamatKtp')}
              {renderInputField('Alamat Tinggal', 'alamatTinggal')}
              {renderInputField('Email', 'email')}
              {renderInputField('No Telp', 'telp')}
              {renderInputField('Kontak Darurat', 'kontakDarurat')}
              {renderInputField('Skills', 'skills')}
              {renderInputField('Bersedia ditempatkan di seluruh kantor perusahaan ', 'bersediaDitempatkan')}
              {renderInputField('Penghasilan Yang Diharapkan', 'harapanPenghasilan')}
              <DynamicFormSection
                  title="Education History"
                  fields={[
                      { label: 'Jenjang Pendidikan Terakhir', name: 'jenjangPendidikan', type: 'text' },
                      { label: 'Nama Institusi Pendidikan', name: 'namaInstitusi', type: 'text' },
                      { label: 'Jurusan', name: 'jurusan', type: 'text' },
                      { label: 'Tahun Lulus', name: 'tahunLulus', type: 'year' },
                      { label: 'IPK', name: 'ipk', type: 'number' }
                  ]}
                  data={biodata.riwayatPendidikan}
                  setData={(data) => setBiodata({...biodata, riwayatPendidikan: data})}
              />
              <DynamicFormSection
                  title="Training History"
                  fields={[
                      { label: 'Nama Kursus/Seminar', name: 'courseName', type: 'text' },
                      { label: 'Sertifikat (Ada/Tidak)', name: 'certificate', type: 'text' },
                      { label: 'Tahun', name: 'year', type: 'Year' }
                  ]}
                  data={biodata.riwayatPelatihan}
                  setData={(data) => setBiodata({...biodata, riwayatPelatihan: data})}
              />
              <DynamicFormSection
                  title="Work History"
                  fields={[
                      { label: 'Company Name', name: 'companyName', type: 'text' },
                      { label: 'Last Position', name: 'lastPosition', type: 'text' },
                      { label: 'Last Income', name: 'lastIncome', type: 'number' },
                      { label: 'Start Year', name: 'startYear', type: 'number' },
                      { label: 'End Year', name: 'endYear', type: 'number' }
                  ]}
                  data={biodata.riwayatPekerjaan}
                  setData={(data) => setBiodata({...biodata, riwayatPekerjaan: data})}
              />
              <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">Submit</button>
          </form>
      </div>
  )
}

export default BiodataForm
