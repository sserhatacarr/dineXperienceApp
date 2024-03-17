/* eslint-disable @typescript-eslint/no-explicit-any */
import * as React from "react";
import {
  DataGrid,
  GridColDef,
  GridRenderCellParams,
  GridTreeNodeWithRender,
} from "@mui/x-data-grid";
import { deleteUser } from "../../service/UserService";
import { useContext } from "react";
import { DataContext } from "../../context/DataContext";

export default function DataTable({ data }: { data: any[] }) {
  const dataContext = useContext(DataContext);

  const columns: GridColDef[] = [
    { field: "id", headerName: "ID", width: 70 },
    { field: "name", headerName: "First name", width: 130 },
    { field: "surname", headerName: "Last name", width: 130 },
    {
      field: "email",
      headerName: "Email",
      width: 250,
      renderCell: (params: GridRenderCellParams<any, any>) => (
        <span style={{ fontWeight: "bold" }}>
          {encryptEmail(params.row.email)}
        </span>
      ),
    },
    {
      field: "userStatus",
      headerName: "Status",
      width: 120,
      renderCell: (params: GridRenderCellParams<any, any>) => (
        <span
          style={{
            fontWeight: "bold",
            color: params.row.userStatus === "ACTIVE" ? "green" : "red",
          }}
        >
          {params.row.userStatus}
        </span>
      ),
    },
    {
      field: "actions",
      headerName: "Actions",
      width: 120,
      sortable: false,
      renderCell: (
        params: GridRenderCellParams<any, any, any, GridTreeNodeWithRender>
      ) => (
        <strong>
          <button onClick={() => handleDelete(params.row.id)}>Delete</button>
        </strong>
      ),
    },
  ];

  const handleDelete = async (id: number) => {
    const response = await deleteUser(id);
    dataContext?.setUpdateApp((prev: boolean) => !prev);
    console.log(response);
  };

  const encryptEmail = (email: string) => {
    const atIndex = email.indexOf("@");
    const encryptedPart = email.substring(1, atIndex).replace(/./g, "*");
    const visiblePart =
      email.substring(0, 1) + encryptedPart + email.substring(atIndex);
    return visiblePart;
  };

  const rows = data.map((item) => ({
    id: item.id,
    name: item.name,
    surname: `${item.surname[0]}****${item.surname[item.surname.length - 1]}`,
    email: item.email,
    userStatus: item.userStatus,
  }));

  return (
    <div className="w-full flex justify-center items-center">
      <div
        style={{
          height: 400,
          width: "80%",
          background: "linear-gradient(to right, #3333, #ff4500)",
          padding: "10px",
        }}
      >
        <DataGrid
          rows={rows}
          columns={columns}
          pageSize={5}
          checkboxSelection
        />
      </div>
    </div>
  );
}
