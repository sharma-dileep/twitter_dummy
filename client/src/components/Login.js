import React from "react";

export default function Login() {
  return (
    <div className=" w-full flex justify-center h-screen items-center card-bordered		">
    <div className=" flex w-64 px-4 flex-col justify-center border-2 border-black h-56 pb-8">
    <input type="text" placeholder="Enter your username" className="input input-bordered input-primary w-full max-w-xs" />
      <div className="form-control self-end">
        <label className="label cursor-pointer">
          <span className="label-text">New User?</span>
          <input type="checkbox" className="toggle" />
        </label>
      </div>
    </div>
    </div>
  );
}
