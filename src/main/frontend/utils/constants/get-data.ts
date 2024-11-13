import TableInterface from "Frontend/generated/com/example/application/entity/TableInterface";
import { DataServiceEndpoint } from "Frontend/generated/endpoints";

export const fetchDataFn = async () => {
    const query: TableInterface[] = await DataServiceEndpoint.getAllData();
  
    const sortData = query.reduce((key: { [source: string]: TableInterface[] }, item: TableInterface) => {
      const { sourceTable } = item;
      if (sourceTable) {
        if (!key[sourceTable]) {
          key[sourceTable] = [];
        }
        key[sourceTable].push(item);
      }
      return key;
    }, {} as { [source: string]: TableInterface[] });
  
    return sortData;
  };