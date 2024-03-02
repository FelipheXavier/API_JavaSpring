import React from 'react'

const Input = ({label,value,updateValue}) => {
  return (
    <>
    <label>{label}</label>
    <input type='' value={value} onChange={(e)=>updateValue(e.target.value)} className='border-2 border-gray-500 p-2 rounded-md outline-blue-700'/>
    </>
  )
}

export default Input
