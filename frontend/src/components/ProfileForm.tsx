import React from "react";
import { Formik, Form, Field } from "formik";
import { saveUser } from "../service/UserService";
import { useContext } from "react";
import { DataContext } from "../context/DataContext";

function ProfileForm() {
  const dataContext = useContext(DataContext);

  const initialValues = {
    name: "",
    surname: "",
    birthDate: "",
    email: "",
    gender: "MALE",
    userStatus: "ACTIVE",
    latitude: 0,
    longitude: 0,
  };

  const handleSubmit = async (values, { resetForm }) => {
    try {
      await saveUser(values);
      resetForm();
      dataContext?.setUpdateApp((prev) => !prev);
      console.log("Kullanıcı başarıyla kaydedildi.");
    } catch (error) {
      console.error("Kullanıcı kaydedilirken bir hata oluştu:", error);
    }
  };

  return (
    <div className="w-full flex justify-center items-center">
      <div style={{ width: "80%" }}>
        <Formik initialValues={initialValues} onSubmit={handleSubmit}>
          {({ values }) => (
            <Form className="bg-gradient-to-r from-gray-300 to-[#ff4500] p-6 rounded-lg">
              <div className="mb-4">
                <label htmlFor="name" className="text-white font-semibold">
                  Name:
                </label>
                <Field
                  type="text"
                  id="name"
                  name="name"
                  className="w-full p-2 mt-1 rounded-md bg-gray-100"
                />
              </div>
              <div className="mb-4">
                <label htmlFor="surname" className="text-white font-semibold">
                  Surname:
                </label>
                <Field
                  type="text"
                  id="surname"
                  name="surname"
                  className="w-full p-2 mt-1 rounded-md bg-gray-100"
                />
              </div>
              <div className="mb-4">
                <label htmlFor="birthDate" className="text-white font-semibold">
                  Birth Date:
                </label>
                <Field
                  type="date"
                  id="birthDate"
                  name="birthDate"
                  className="w-full p-2 mt-1 rounded-md bg-gray-100"
                />
              </div>
              <div className="mb-4">
                <label htmlFor="email" className="text-white font-semibold">
                  Email:
                </label>
                <Field
                  type="email"
                  id="email"
                  name="email"
                  className="w-full p-2 mt-1 rounded-md bg-gray-100"
                />
              </div>
              <div className="mb-4">
                <label htmlFor="gender" className="text-white font-semibold">
                  Gender:
                </label>
                <Field
                  as="select"
                  id="gender"
                  name="gender"
                  className="w-full p-2 mt-1 rounded-md bg-gray-100"
                >
                  <option value="MALE">Male</option>
                  <option value="FEMALE">Female</option>
                </Field>
              </div>
              <div className="mb-4">
                <label
                  htmlFor="userStatus"
                  className="text-white font-semibold"
                >
                  Status:
                </label>
                <Field
                  as="select"
                  id="userStatus"
                  name="userStatus"
                  className="w-full p-2 mt-1 rounded-md bg-gray-100"
                >
                  <option value="ACTIVE">Active</option>
                  <option value="INACTIVE">Inactive</option>
                </Field>
              </div>
              <div className="mt-6">
                <button
                  type="submit"
                  className="bg-white text-orange-500 font-semibold py-2 px-4 rounded-md hover:bg-orange-400"
                >
                  Submit
                </button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </div>
  );
}

export default ProfileForm;
