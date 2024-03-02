import { useState } from 'react'

import './App.css'
import Header from './components/header'

import Content from './components/Content'

import Modal from './components/Modal';


function App() {

  const [isOpen,setIsOpen] = useState(false);
  
  const modalHandle = () =>{
    setIsOpen((prev)=>!prev)
    
  }

  return (
    <>
      <Header/>
      <Content open={isOpen}/>
      {!isOpen && <button className="fixed w-20 sm:w-18 md:w-19 h-20 sm:h-18 md:h-19 bottom-8 right-5 rounded-full bg-blue-700 flex justify-center items-center text-5xl cursor-pointer" onClick={modalHandle}><p className='mb-2'>+</p></button>}
      
      {isOpen && <Modal setIsOpen={setIsOpen}/>}
    </>
  )
}

export default App
