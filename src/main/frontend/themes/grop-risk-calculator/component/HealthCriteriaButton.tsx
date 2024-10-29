import { Button } from '@vaadin/react-components';
import React from 'react'


interface Option<T> {
  id: string; // Unique identifier
  value: T; 
}

interface ItemProps<T> {
  items: Option<T>[];
  selectedId: string; // Identifier for selected item
  title: string;
}

const HealthCriteriaButton = <T extends React.ReactNode>({title, items, selectedId}: ItemProps<T>) => {
  const [selected, setSelected] = React.useState<string>(selectedId);

  const handleClick = (id: string) => {
    setSelected(id);
  };

  return (
    <div className=' '>
        <div className='flex justify-center '>
        <div className='w-full text-[12px] lg:text-[13px] font-semibold '>{title}</div>
          <div className='flex gap-[10px] '>
          {items.map((t ,i ) => (
            <Button 
              key={i}
              onClick={() => handleClick(t.id)}
              className="w-[100px] rounded-[1px] text-[12px] lg:text-[14px]"
              style={{ color:'#fff', backgroundColor: selected === t.id ? ' rgb(116, 142, 99)' : 'grey'}}
            >
              {t.value}
            </Button>
          ))}
          </div>
      </div>
    </div>
  );
};

export default HealthCriteriaButton;
