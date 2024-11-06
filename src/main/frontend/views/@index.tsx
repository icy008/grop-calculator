import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { Button, Icon, Item } from '@vaadin/react-components';

// export const config: ViewConfig = { menu: { ordser: 1, icon: 'line-awesome/svg/file.svg' }, title: 'Empty' };
import { Select } from '@vaadin/react-components/Select.js';
import ButtonGroup from 'Frontend/components/ButtonGroup';
import Heading from 'Frontend/components/Heading';
import {   DataServiceEndpoint, QueryEnpoint  } from 'Frontend/generated/endpoints';

import { sayHello } from 'Frontend/generated/HelloWorldService';



import HealthCriteriaButton from 'Frontend/themes/grop-risk-calculator/component/HealthCriteriaButton';
import Test from 'Frontend/themes/grop-risk-calculator/component/Test';
import { CombinedData } from 'Frontend/utils/types';
import React, { useState } from 'react';

interface Age {
  id: number;
  label: string;
  value: number;
  timestamp: string;
}

interface CombinedDataInterface {
  id: number;
  label: string;
  value: any; // Adjust this type if you know the exact type of `value`
  timestamp: string; // Assuming this is returned as a string; use `Date` if needed
  source_table: string;
}
export default function EmptyView() {
  const [ageValue, setAgeValue] = useState<number>(0);
  const [sexValue, setSexValue] = useState<number>(0);
  const [barthelIndexValue, setBarthelIndexValue] = useState<number>(0);
  const [bnpValue, setBnpValue] = useState<number>(0);
  const [sodiumValue, setSodiumValue] = useState<number>(0);
  const [aceArbValue, setAceArbValue] = useState<number>(0);
  const [historyOfHfValue, setHistoryOfHfValue] = useState<number>(0);
  const [sbpValue, setSbpValue] = useState<number>(0);
  const [hemoglobinValue, setHemoglobinValue] = useState<number>(0);
  const [albuminValue, setAlbuminValue] = useState<number>(0);
  const [bunValue, setBunValue] = useState<number>(0);
  const [combinedData, setCombinedData] = useState([]);
  const [ages, setAges] = useState<Age[]|any>([]);
  const [datas, setData] = useState<CombinedData[]>([]);

    // Calculate ΣβX
  const totalValue =
        ageValue +
        sexValue +
        barthelIndexValue +
        bnpValue +
        sodiumValue +
        aceArbValue +
        historyOfHfValue +
        sbpValue +
        hemoglobinValue +
        albuminValue +
        bunValue;

  // Calculate 1-year and 3-year mortality rates
  const oneYearMortality = (1 - 0.77921 * Math.exp(totalValue - 1.37464)) * 100;
  const threeYearMortality = (1 - 0.51646 * Math.exp(totalValue - 1.37464)) * 100;


// const oneYearMortality = Math.max(0, (1 - 0.77921 * Math.exp(totalValue - 1.37464)) * 100);
// const threeYearMortality = Math.max(0, (1 - 0.51646 * Math.exp(totalValue - 1.37464)) * 100);


      React.useEffect(() => {
        item()
         
    }, []);
    
const item =  async () => {

  const query = await QueryEnpoint.getAllData()

  const datas = await DataServiceEndpoint.getCombinedData()

  console.log('from query' , query);
  console.log('from datas' , datas);



  // const data = await   AllDataEndpoint.getAllData()
  query.map(items => console.log( items))

  datas.map(items => console.log( items)) 


  
}


  return (
    <div>
      <Heading/>
        <div className='w-full  bg bg-red- flex items-center justify-center'>
          <div className='container w-[70%] h- sm:flex  bg-primary-color-50pct justify-around mt-[x] py-[30px] flex flex-col '>
            <div className='container-1 w-[] bg-fuchsia- flex  flex-col gap-[20px]  '>
              {/* <div>
              <div className='grid grid-cols-3 gap-[1px] mt-[10px] items-center bg-red- '>
                <Button className='rounded-l-[6px] text-button-text-color rounded-r-[0px]' theme="small">When to use </Button>
                <Button className='rounded-[1px] text-button-text-color' theme="small">Pearls/Pitfalls
                <Icon style={{ height: '12px', width: '12px' }} slot={'suffix'} icon="vaadin:info-circle" />
                </Button>
                <Button className='rounded-r-[6px] text-button-text-color rounded-l-[0px]' theme="small">Why use
                <Icon style={{ height: '12px', width: '12px' }} slot={'suffix'} icon="vaadin:question-circle" />
                </Button>
              </div>
              </div> */}
            <ButtonGroup
              label="Age"
              items={[
                { title: '80 - 84' , value: 0 },
                { title: '85 - 89', value: 0.29129 },
                { title: 'Age ≥ 90', value: 0.43853 },
              ]}
              onValueChange={setAgeValue}
            />
      
            <ButtonGroup
              label="Sex"
              items={[
                { title: 'Male: ♂', value: 0.51578 },
                { title: 'Female: ♀', value: 0 },
              ]}
              onValueChange={setSexValue}
            />

            <ButtonGroup
              label="Barthel index"
              items={[
                { title: '≥ 90', value: 0 },
                { title: '61 - 90', value: 0.34902 },
                { title: '< 60', value: 0.78954 },
              ]}
              onValueChange={setBarthelIndexValue}
            />
            <ButtonGroup
              label="History of HF"
              items={[
                { title: '( - )', value: 0 },
                { title: '( + )', value: 0.35664 },
              ]}
              onValueChange={setHistoryOfHfValue}
            />
              <ButtonGroup
                label="SBP"
                items={[
                  { title: '≥ 100', value: 0 },
                  { title: '≤ 100', value: 0.31585 },
                ]}
                onValueChange={setSbpValue}
            />
            <ButtonGroup
              label="Hemoglobin"
              items={[
                { title: '≥ 12', value: 0 },
                { title: '10 - 11.9', value: 0.23813 },
                { title: '< 10', value: 0.40091 },
              ]}
              onValueChange={setHemoglobinValue}
            />
            </div>
            <div className='container-2 flex flex-col gap-[20px] '>
            <ButtonGroup
              label="Albumin"
              items={[
                { title: '≥ 3', value: 0 },
                { title: '< 3', value: 0.37812 },
              ]}
              onValueChange={setAlbuminValue}
            />
            <ButtonGroup
              label="BUN"
              items={[
                { title: '< 25', value: 0 },
                { title: '≥ 25', value: 0.21341 },
              ]}
              onValueChange={setBunValue}
            />
            <ButtonGroup
            label="BNP"
            items={[
              { title: '< 300', value: 0 },
              { title: '≥ 300', value: 0.29743  },
            ]}
            onValueChange={setBnpValue}
             />
            <ButtonGroup
              label="Sodium"
              items={[
                { title: '≥ 130', value: 0 },
                { title: '< 130', value: 0.60705 },
              ]}
              onValueChange={setSodiumValue}
            />
            <ButtonGroup
              label="ACE/ARB use"
              items={[
                { title: '( + )', value: 0.20517 },
                { title: '( - )', value: 0 },
              ]}
              onValueChange={setAceArbValue}
            />
              {/* <div>Total Value: {totalValue}</div> */}

              {/* <div className='h-[1px] w-full bg-primary-color mt-[ ]'></div> */}
            <div> 
              <div className='h-[120px] w-full bg-primary-color-50pct p-[5px] rounded-[12px]'>
              <div className='flex justify-center items-center h-full  ]'>
                <div className='w-[100%] h-full bg-primary-color flex text-white rounded-[12px]  py-[10px]'>
                  <div className='w-full h-full   border-r-[1px] flex justify-center items-center'> 
                  <div className='text-[12px]  md:text-[21px] font-bold'>
                  {totalValue.toFixed(2)} points
                  </div>
                  </div>
                  <div className='w-full h-full flex justify-center items-center '>
                  <div className='flex flex-col'>
                  <div className='text-[12px] md:text-[21px] font-bold'>{oneYearMortality.toFixed(2)}%</div>
                  <span className='text-[10px] md:text-[12px] font-bold'>1-year mortality</span>
                  </div>
                  </div>
                  <div className='w-full h-full   border-l-[1px] flex justify-center items-center'>
                  <div className='flex flex-col'>
                <div className='text-[12px] md:text-[21px] font-bold'>{threeYearMortality.toFixed(2)}%</div>
                <span className='text-[10px] md:text-[12px] font-bold'>3-year mortality</span>
                </div>  
                  </div>
                </div>
              </div>
              </div>
            </div>
            </div>

          </div>
        </div>


    </div>
  );
}
