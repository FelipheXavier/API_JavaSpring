import React, { useState } from 'react'
import Input from './Input'
import { CreateANewFood } from '../RequestData';

const Modal = ({setIsOpen}) => {

  const [name,setName] = useState("");
  const [photo,setPhoto] = useState("");
  const [price,setPrice] = useState("");
  const [description,setDescription] = useState("");

  const submit = () =>{
    
    const food = {
    name,
    description,
    photo,
    price}
    CreateANewFood(food).then((res)=>{
      console.log(res.data);
    })
    setIsOpen(false);
  }
  
  return (
    <div className='w-screen h-screen flex items-center justify-center '>
      <div className='border-2 border-black  flex flex-col  w-4/6 p-10 rounded-2xl'>
        <h2 className='text-2xl font-Poppins pb-5'>Create a new Food</h2>
        <form className='flex flex-col'>
          <Input label={"Name"} value={name} updateValue={setName}/>
          <Input label={"Photo"} value={photo} updateValue={setPhoto}/>
          <Input label={"Price"} value={price} updateValue={setPrice}/>
          <Input label={"Description"} value={description} updateValue={setDescription}/>
        </form>
          <button className='bg-blue-800 p-2 mt-7 rounded-lg text-white font-Poppins' onClick={submit}>Create</button>
      </div>
    </div>
  )
}

export default Modal
