import React from 'react';
import './index.css';

const Input1 = ({ placeholder, name, type, value, onChange, error }) => {
	console.log(name, error);
	return (
		<div className="mb-3">
			<label className="inputLabel">{placeholder}</label>
			<input
				type={type}
				className={error ? "form-control is-invalid" : "form-control"}
				name={name}
				value={value}
				onChange={onChange}
			/>
			<div className="invalid-feedback">{error}</div>
		</div>
	);
};

export { Input1 };
