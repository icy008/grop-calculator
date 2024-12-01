import React from 'react'
interface ItemGruop {
  label:string 
  data :any[]
  onValueChange:any 
}


const ItemGruop = ({data ,label} : ItemGruop ) => {
  // const [selected, setSelected] = React.useState<number>();

    return (
      <div className="relative bg-red-">
        <div className="">
          <p className="text-primary-color font-semibold text-[12px] sm:text-[18px]">{label}</p>
          <div className="p-[5px]  rounded-[12px]  border-white  bg-white   shadow-xl ">
            
          {data.map(items => 
            <div
            key={items.id}>
              
            </div>

          )}

          </div>
        </div>
      </div>
  
  )
}

export default ItemGruop