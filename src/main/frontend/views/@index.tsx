import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import ButtonGroup from 'Frontend/components/ButtonGroup';
import Footer from 'Frontend/components/Footer';
import Heading from 'Frontend/components/Heading';
import React, { useState ,useEffect  } from 'react';
import ResultContainer from 'Frontend/components/ResultContainer';
import { DataEndpoint, MortalityEndpoint } from 'Frontend/generated/endpoints';
import { formatData, groupData } from 'Frontend/utils/constants/formatData';
import MortalityResult from 'Frontend/generated/com/example/application/services/MortalityEndpoint/MortalityResult';



export default function EmptyView() {
  const [data, setData] = useState< groupData[]>([]);
  const [mortality, setMortality] = useState<MortalityResult>();
  const [selectedValues, setSelectedValues] = useState<{ [key: string]: number }>({});


  const [selectedOptions, setSelectedOptions] = useState(() => {
    const initialSelections: { [key: string]: number } = {};
  
    data.forEach((category) => {
      initialSelections[category.title] = 0; // Set default selection to 0
    });
  
    return initialSelections;
  });


    useEffect(() => {

      const totalSum = Object.values(selectedValues).reduce((acc, val) => acc + val, 0);

      DataEndpoint.getAllDatas().then(res => {setData(formatData(res)) } );
      MortalityEndpoint.calculateMortality(totalSum).then( total => setMortality(total));

      // console.log(selectedValues);
    }, [selectedValues]);


  const handleValueChange = (title: string, value: number , index:number) => {

    setSelectedValues((prevSelectedValues) => ({
      ...prevSelectedValues,
      [title]: value, 
    }));

  }



  return (
    <div>
      <div className='sticky  w-full z-30'>
      <Heading/>
      </div>
        <div className='w-full  bg bg-red- flex items-center justify-center bg-primary-color-'>
          <div className='w-[100%] sm:w-[90%] md:w-[90%] lg:w-[70%] bg-primary-color-50pct flex justify-center shadow-inner  mt-[] rounded-[]'>
            <div className=' w-full flex flex-col items-center'>
              <div className='w-[90%] mx-[20px] sm:w-[90%] md:w-[80%]   sm:mt-[10px] flex flex-col gap-[20px] md:gap-[30px]'>
              {  data.map((item:groupData, index:number) => (

                    <ButtonGroup
                      key={index}
                      label={item.title }
                      items={item.data.map( d => ({
                        title: d.label  ,
                        value: d.value  ,
                        units: d.units, 
                        id:d.id

                      }))}
                      onValueChange={(value) => {
                        handleValueChange(item.title, value, index);
                        setSelectedOptions((prevSelections) => ({
                          ...prevSelections,
                          [item.title]: value, 
                        }));
                      }}        
                      defaultSelectedId={selectedOptions[item.title] === index}

                      />
                  ))}
              <div className='mb-[50px]'> 
                {mortality && (
                <ResultContainer oneYearMortality={mortality.oneYearMortality} threeYearMortality={mortality.threeYearMortality} />
                 )}
              </div>
              </div>
            </div>
          </div>
        </div>
        {/* <Footer/> */}
    </div>
  );
}