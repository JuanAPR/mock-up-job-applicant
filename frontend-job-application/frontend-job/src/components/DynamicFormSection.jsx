import React from 'react';

const DynamicFormSection = ({ title, fields, data, setData }) => {
    const handleChange = (index, field, value) => {
        const newData = data.map((item, i) => (i === index ? { ...item, [field]: value } : item));
        setData(newData);
    };

    const handleAdd = () => {
        setData([...data, fields.reduce((acc, field) => ({ ...acc, [field.name]: '' }), {})]);
    };

    const handleRemove = (index) => {
        setData(data.filter((_, i) => i !== index));
    };

    return (
        <div className="mb-4">
            <h3 className="text-2xl font-bold mb-2">{title}</h3>
            {data.map((item, index) => (
                <div key={index} className="mb-2 border p-2 rounded">
                    {fields.map((field) => (
                        <div key={field.name} className="mb-2">
                            <label className="block text-gray-700">{field.label}</label>
                            <input
                                type={field.type}
                                name={field.name}
                                value={item[field.name]}
                                onChange={(e) => handleChange(index, field.name, e.target.value)}
                                className="w-full px-3 py-2 border rounded"
                            />
                        </div>
                    ))}
                    <button type="button" onClick={() => handleRemove(index)} className="text-red-500 hover:text-red-700">Remove</button>
                </div>
            ))}
            <button type="button" onClick={handleAdd} className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">Add {title}</button>
        </div>
    );
};

export default DynamicFormSection;
