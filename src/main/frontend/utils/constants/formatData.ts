import TableInterface from "Frontend/generated/com/example/application/utils/TableInterface";

export interface groupData  {
    title: string;
    data:{
      id:number
      label:string,
      value:number,
      units:string
    }[];
  }


export const formatData = (data: TableInterface[]): groupData[]=> {
    const groupedData: { [key: string]: { id:number ,label: string; value: number , units:string , }[] } = {};
    data.forEach(({ sourceTable, label, value ,units , id }) => {
      if (!sourceTable) return;
      if (!groupedData[sourceTable]) {
        groupedData[sourceTable] = [];
      }
      groupedData[sourceTable].push({id:Number(id), label: label , value: Number(value) , units:units });
    });
  
    return Object.keys(groupedData).map((title) => ({
      title,
      data: groupedData[title],
    }));
  
}


// const datas = [
//     {
//       title: 'Category 1',
//       data: [
//         { label: 'Option 1', value: 10 },
//         { label: 'Option 2', value: 20 },
//         { label: 'Option 3', value: 30 },
//       ],
//     },
//     {
//       title: 'Category 2',
//       data: [
//         { label: 'Option A', value: 5 },
//         { label: 'Option B', value: 15 },
//         { label: 'Option C', value: 25 },
//       ],
//     },
//     {
//       title: 'Category 3',
//       data: [
//         { label: 'Option A', value: 5 },
//         { label: 'Option B', value: 115 },
//         { label: 'Option C', value: 25 },
//       ],
//     },
//   ];