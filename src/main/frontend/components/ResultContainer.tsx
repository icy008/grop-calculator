import React from 'react'

interface ResultInterface {
  total: number;
  oneyear:number; 
  threeyear:number;

}

const ResultContainer = ({total ,oneyear , threeyear} : ResultInterface) => {
  return (
    <div className='h-[150px] w-full bg-white p-[5px] rounded-[12px]  '>
    <div className='flex justify-center items-center h-full  ]'>
      <div className='w-[100%] h-full bg-primary-color flex text-white rounded-[12px]  py-[10px]'>
        {/* <div className='w-full h-full   border-r-[1px] flex justify-center items-center'> 
        <div className='text-[12px]  md:text-[21px] font-bold'>
        {total.toFixed(2)} points
        </div>
        </div> */}
        <div className='w-full h-full flex justify-center items-center '>
        <div className='flex flex-col'>
        <div className='text-[16px] md:text-[32px] font-bold'>{oneyear.toFixed(1)}%</div>
        
        <span className='text-[12px] md:text-[12px] font-bold'>1-year mortality</span>
        </div>
        </div>
        <div className='w-full h-full   border-l-[1px] flex justify-center items-center'>
        <div className='flex flex-col'>
      <div className='text-[16px] md:text-[32px]  font-bold'>{threeyear.toFixed(1)}%</div>
      <span className='text-[12px] md:text-[12px] font-bold'>3-year mortality</span>
      </div>  
        </div>
      </div>
    </div>
    </div>
  )
}

export default ResultContainer