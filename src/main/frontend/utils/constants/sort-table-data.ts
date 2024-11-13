import { data } from "./data";

interface DataItem {
    value: number;
    id: number;
    timestamp: string;
    sourceTable: string;
    label: string;
  }
  
 const sortData = data.reduce((key: { [source: string]: DataItem[] }, item: DataItem) => {
    const { sourceTable } = item;
    if (sourceTable) {
      if (!key[sourceTable]) {
        key[sourceTable] = [];
      }
      key[sourceTable].push(item);
    }
    return key;
  }, {});
  
  export { sortData };