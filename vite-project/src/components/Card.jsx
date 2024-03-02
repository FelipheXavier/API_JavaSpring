import React from 'react'

const Card = ({name,description,photo,price}) => {
  return (
    <div className="w-full h-9/12 shadow-2xl p-10 flex flex-col rounded-lg">
      <h2 className='font-Inter h-1/11 sm:h-1/12 pb-5 text-3xl'>{name}</h2>
      <img className="rounded-lg w-full h-3/5 " 
      src={photo}/>
      <p className='pt-5 text-lg md:text-xl h-1/3 overflow-auto'>{description}</p>
      <h3 className='text-4xl mt-5  text-blue-800'>${price}</h3>
    </div>
  )
}

export default Card;
