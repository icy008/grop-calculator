import MortalityResult from 'Frontend/generated/com/example/application/services/MortalityEndpoint/MortalityResult';
import React from 'react'

interface ResultInterface {
  total?: number;
  oneyear:number; 
  threeyear:number;

}

const ResultContainer = ({oneYearMortality , threeYearMortality} : MortalityResult) => {
  return (
    <div className='h-[150px] w-full bg-white p-[5px] rounded-[12px]  '>
    <div className='flex justify-center items-center h-full  ]'>
      <div className='w-[100%] h-full  bg-gradient-to-r from-primary-color-150pct to-primary-color flex text-white rounded-[12px]  py-[10px]'>
        <div className='w-full h-full flex justify-center items-center '>
        <div className='flex flex-col'>
        <div className='text-[24px] md:text-[32px] font-bold'>{oneYearMortality.toFixed(1)}%</div>
        
        <span className='text-[16px] md:text-[22px] font-bold'>1-year mortality</span>
        </div>
        </div>
        <div className='w-full h-full   border-l-[1px] flex justify-center items-center'>
        <div className='flex flex-col'>
      <div className='text-[24px] md:text-[32px]  font-bold'>{threeYearMortality.toFixed(1)}%</div>
      <span className='text-[16px] md:text-[22px] font-bold'>3-year mortality</span>
      </div>  
        </div>
      </div>
    </div>
    </div>
  )
}

export default ResultContainer