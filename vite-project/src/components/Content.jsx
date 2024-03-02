import React, { useEffect, useState } from 'react'

import { FoodList } from '../RequestData';
import Card from './Card';

const Content = ({open}) => {

  const [foodList, setFoodList] = useState([]);

  useEffect(()=>{
    FoodList().then((res)=>{
      setFoodList(res.data)
      
    }).
    catch(error=>{
      console.log(error)
    })
  })

  return (
    <>
    {!open && 
    
    <div className='flex justify-center w-full sm:p-16 md:p-7 p-5 '>
        <div className='grid grid-cols-1 sm:grid-cols-3 md:grid-cols-2 lg:grid-cols-3 gap-20 md:gap-10 h-full w-full'>
         {foodList.map((food)=>(
          <Card name={food.name} description={food.description} photo={food.photo} price={food.price} key={food.id}/>
         ))}   
        </div>
    </div>
    
    }
    
    </>
  )
}

export default Content
