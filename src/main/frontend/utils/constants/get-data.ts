import TableInterface from "Frontend/generated/com/example/application/utils/TableInterface";
import { DataEndpoint } from "Frontend/generated/endpoints";

export const fetchDataFn = async () => {
    const query = await DataEndpoint.getAllDatas();

    // Check if query is defined and filter out undefined items
    const filteredQuery: TableInterface[] = (query || []).filter((item): item is TableInterface => item !== undefined);

    const sortData = filteredQuery.reduce((key, item) => {
        const sourceTable = item.sourceTable ?? ""; // Use empty string if sourceTable is undefined
        if (!key[sourceTable]) {
            key[sourceTable] = [];
        }
        key[sourceTable].push(item);
        return key;
    }, {} as { [source: string]: TableInterface[] });

    return sortData;
};
